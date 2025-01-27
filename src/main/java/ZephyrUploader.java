import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



import java.io.File;

public class ZephyrUploader {

    public static void main(String[] args) {
        // Замените на свой API токен и ключ проекта
        String apiToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2FuZHJpaW9tZWxueXRza3lpLmF0bGFzc2lhbi5uZXQiLCJ1c2VyIjp7ImFjY291bnRJZCI6IjcxMjAyMDowNDI2YWEzMC00ZDJmLTRmMDMtOGYyMi1hNDU1ZTE2NjIzZjIiLCJ0b2tlbklkIjoiOGJjZWEwMjctYzcyNy00MzU5LTk3ZWMtZWVhZGU5OTQ0MDc3In19LCJpc3MiOiJjb20ua2Fub2FoLnRlc3QtbWFuYWdlciIsInN1YiI6IjgzODBmMDQ3LWQ2NjgtM2YxYi1iMDgzLWEwMmMyM2RlODE0MyIsImV4cCI6MTc2OTE4MDUyNiwiaWF0IjoxNzM3NjQ0NTI2fQ.LP1J2yKg-zaGbCbIgZ-b-nLlsVafCYWRy1TAhci0SMA";
        String projectKey = "TP";

        // Укажите путь к вашему JUnit XML отчёту
        File reportFile = new File("test-output/MyTestSuite/LoginTests.xml");

        // URL для загрузки JUnit отчёта в Zephyr Scale
        String zephyrApiUrl = "https://api.zephyrscale.smartbear.com/v2/automations/executions/junit";

        // Создаём HTTP клиент
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(zephyrApiUrl + "?projectKey=" + projectKey + "&autoCreateTestCases=true");

            // Добавляем заголовок авторизации
            post.setHeader("Authorization", "Bearer " + apiToken);

            // Формируем запрос с файлом отчёта
            HttpEntity entity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", reportFile, ContentType.APPLICATION_XML, reportFile.getName())
                    .build();

            post.setEntity(entity);

            // Выполняем запрос
            HttpResponse response = httpClient.execute(post);
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}