package at.htlleonding.Kinalyze.Service;

import at.htlleonding.Kinalyze.Entity.FileEntity;
import jakarta.persistence.Lob;

public class AnalyzeAll {
    private String user_id;
    private String file_name;
    private String file_type;
    private Long file_size;
    private String file_content;
    private FileEntity analyzedCode;

    public FileEntity getAalyzedCode() {
        return analyzedCode;
    }
    public AnalyzeAll(String user_id, String file_name, String file_type, Long file_size, String file_content){
        this.user_id = user_id;
        this.file_name = file_name;
        this.file_type = file_type;
        this.file_size = file_size;
        this.file_content = file_content;
        analyzedCode = analyzeAll(file_content);
    }
    public FileEntity analyzeAll(String code){
        int data_type = 0; //Funktion not implemented yet
        String constructs = ""; //Funktion not implemented yet
        String unreadables = ""; //Funktion not implemented yet
        return new FileEntity(user_id, file_name, file_type, file_size, file_content, LangDetection.LangDetect(file_content),
                LanguageAnalyzer.analyzeLanguage(file_content), IndentationAnalyzer.checkIndentation(file_content), ComplexityAnalyzer.analyzeCodeComplexity(file_content),
                data_type, BadInitsAnalyzer.analyzeCode(file_content), BadPracticeAnalyzer.analyzeCode(file_content), CommentAnalyzer.analyzeComments(file_content),
                constructs, unreadables, NamingConventionAnalyzer.analyzeCodeNamingConventions(file_content), PerformanceAnalyzer.shortAnalyze(file_content), LineMethodRatioAnalyzer.calculateLineMethodRatio(file_content)
                );
    }
}
