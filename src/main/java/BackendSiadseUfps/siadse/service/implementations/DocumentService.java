package BackendSiadseUfps.siadse.service.implementations;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BackendSiadseUfps.siadse.repository.ProjectRepository;
import BackendSiadseUfps.siadse.entity.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DocumentService {

	@Autowired
    private ProjectRepository projectRepository;

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public XWPFDocument loadTemplate(String filePath) throws Exception {
        try (InputStream templateInputStream = new ClassPathResource(filePath).getInputStream()) {
            return new XWPFDocument(templateInputStream);
        }
    }

    public void replacePlaceholder(XWPFDocument document, Map<String, String> placeholders) {
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        replaceInParagraph(paragraph, placeholders);
                    }
                }
            }
        }
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            replaceInParagraph(paragraph, placeholders);
        }
    }

    private void replaceInParagraph(XWPFParagraph paragraph, Map<String, String> placeholders) {
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs != null) {
            StringBuilder paragraphTextBuilder = new StringBuilder();
            for (XWPFRun run : runs) {
                paragraphTextBuilder.append(run.getText(0));
            }
            String paragraphText = paragraphTextBuilder.toString();
            String replacedText = paragraphText;
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                replacedText = replacedText.replace(entry.getKey(), entry.getValue());
            }

            for (int i = 0; i < runs.size(); i++) {
                if (i == 0) {
                    runs.get(i).setText(replacedText, 0);
                } else {
                    runs.get(i).setText("", 0);
                }
            }
        }
    }

    public ByteArrayResource generateDocument(Project project) throws Exception {
        XWPFDocument document = loadTemplate("resources/FO-IN-14.docx");

        Map<String, String> placeholders = Map.of(
                "${NOMBRE_PROYECTO}", project.getProjectName(),
                "${NOMBRE_ESTUDIANTE}", project.getProjectLeader().getName(),
                "${NOMBRE_SEMILLERO}", project.getSemillero().getNombre(),
                "${DIRECTOR}", project.getSemillero().getDirector().getName(),
                "${CELULAR}", project.getProjectLeader().getCelular()
        );

        replacePlaceholder(document, placeholders);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document.write(outputStream);
        return new ByteArrayResource(outputStream.toByteArray());
    }
}
