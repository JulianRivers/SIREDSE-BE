package BackendSiadseUfps.siadse.controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import org.modelmapper.ModelMapper;

import BackendSiadseUfps.siadse.dto.DocumentRequest;
import BackendSiadseUfps.siadse.dto.ProjectDTO;
import BackendSiadseUfps.siadse.entity.Formato14;
import BackendSiadseUfps.siadse.entity.Project;
import BackendSiadseUfps.siadse.entity.Semillero;
import BackendSiadseUfps.siadse.entity.User;
import BackendSiadseUfps.siadse.service.implementations.DocumentService;
import BackendSiadseUfps.siadse.service.interfaces.Formato14Service;
import BackendSiadseUfps.siadse.service.interfaces.ProjectService;
import BackendSiadseUfps.siadse.service.interfaces.UserService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @PostMapping("/generate-document")
    public ResponseEntity<ByteArrayResource> generateDocument(@RequestBody DocumentRequest documentRequest) {
        try {
            // Cargar la plantilla
            XWPFDocument document = loadTemplate("classpath:documentos/FO-IN-14.docx");
            replacePlaceholder(document, documentRequest);

            // Escribir el documento en un ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.write(outputStream);

            // Crear el recurso para la respuesta
            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=proyecto.docx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(outputStream.size())
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private XWPFDocument loadTemplate(String filePath) throws Exception {
        File file = ResourceUtils.getFile(filePath);
        try (FileInputStream templateInputStream = new FileInputStream(file)) {
            return new XWPFDocument(templateInputStream);
        }
    }

    private void replacePlaceholder(XWPFDocument document, DocumentRequest documentRequest) {
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        replaceInParagraph(paragraph, documentRequest);
                    }
                }
            }
        }
    }

    private void replaceInParagraph(XWPFParagraph paragraph, DocumentRequest documentRequest) {
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs != null) {
            StringBuilder paragraphTextBuilder = new StringBuilder();
            for (XWPFRun run : runs) {
                paragraphTextBuilder.append(run.getText(0));
            }
            String paragraphText = paragraphTextBuilder.toString();

            // Obtener el año actual y el semestre
            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            String semestre;
            Month currentMonth = currentDate.getMonth();
            if (currentMonth.compareTo(Month.JULY) < 0) {
                semestre = "I";
            } else {
                semestre = "II";
            }

            String replacedText = paragraphText
                    .replace("{{NOMBRE_PROYECTO}}", documentRequest.getProjectName())
                    .replace("{{NOMBRE_ESTUDIANTE}}", documentRequest.getStudentName())
                    .replace("{{NOMBRE_SEMILLERO}}", documentRequest.getSemilleroName())
                    .replace("{{EMAIL}}", documentRequest.getDirectorEmail())
                    .replace("{{CELULAR}}", documentRequest.getDirectorPhone())
                    .replace("{{DIRECTOR}}", documentRequest.getDirectorName())
                    .replace("{{ANIO}}", String.valueOf(currentYear))
                    .replace("{{SEMESTRE}}", semestre);

            for (int i = 0; i < runs.size(); i++) {
                if (i == 0) {
                    runs.get(i).setText(replacedText, 0);
                } else {
                    paragraph.removeRun(i);
                }
            }
        }
    }
}
