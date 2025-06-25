package com.keyuan.java.ai.langchain4j;

import com.keyuan.java.ai.langchain4j.assistant.Assistant;
import com.keyuan.java.ai.langchain4j.assistant.DotaAnalysisAgent;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.onnx.HuggingFaceTokenizer;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class langChain4JTest {
    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    private DotaAnalysisAgent analysisAgent;

    @Autowired
    private Assistant assistant;

    //    @Test
//    public void testLangChain4j() {
//        // This is a placeholder for the actual test implementation.
//        // You can add your test logic here.
//        OpenAiChatModel model = OpenAiChatModel.builder()
//                .baseUrl("http://langchain4j.dev/demo/openai/v1")
//                .apiKey("demo")
//                .modelName("gpt-4o-mini")
//                .build();
//
//        String answer = model.chat("Hello, how are you?");
//        System.out.println(answer);
//    }
    @Test
    public void testQwenChatModel() {
        String answer = qwenChatModel.chat("Hello, how are you?");
        System.out.println(answer);
    }

    @Test
    public void testCreateAiService() {
        String answer1 = assistant.chat(1, "My name is Keyuan?");
        String answer3 = assistant.chat(1, "What is my name?");
        String answer2 = assistant.chat(2, "What is the weather like today?");
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }

    @Test
    public void testDotaAnalysisAgent() {
        String answer = analysisAgent.analysisHero(1, "Give me analysis of the hero in Dota 2, including his strengths, and weaknesses.", "Kunkka");
        System.out.println(answer);
    }

    @Test
    public void testSystemDocumentLoader() {
        Document document = FileSystemDocumentLoader.loadDocument("E:\\knowledge\\测试.txt");
        System.out.println(document.text());
    }

    @Test
    public void testSystemDocumentLoaderPdf() {
        Document document = FileSystemDocumentLoader.loadDocument("E:\\knowledge\\科室信息.pdf");
        System.out.println(document.metadata());
    }

    @Test
    public void testDocumentSplitter() {
    //使用FileSystemDocumentLoader读取指定目录下的知识库文档
    //并使用默认的文档解析器对文档进行解析(TextDocumentParser)
        Document document = FileSystemDocumentLoader.loadDocument("E:/knowledge/人工智能.md");
    //为了简单起见，我们暂时使用基于内存的向量存储
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>
                ();
    //自定义文档分割器
    //按段落分割文档：每个片段包含不超过 300个token，并且有 30个token的重叠部分保证连贯性
    //注意：当段落长度总和小于设定的最大长度时，就不会有重叠的必要。
        DocumentByParagraphSplitter documentSplitter = new DocumentByParagraphSplitter(
                300,
                30,
    //token分词器：按token计算
                new HuggingFaceTokenizer());

        EmbeddingStoreIngestor
                .builder()
                .embeddingStore(embeddingStore)
                .documentSplitter(documentSplitter)
                .build()
                .ingest(document);

        System.out.println(embeddingStore);
    }
}
