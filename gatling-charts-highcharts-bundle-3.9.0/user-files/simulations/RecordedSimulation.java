
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:8080")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.9,he-IL;q=0.8,he;q=0.7")
      .upgradeInsecureRequestsHeader("1")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");


    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("request_0")
          .get("/DevOps_FinalProj_EyalDanielYuvalAviv/main.jsp?user_name=eyal&password=Shenshakir")
          .headers(headers_0)
      );

	  setUp(
		  scn.injectOpen(
			rampUsers(38).during(5), // 3
			constantUsersPerSec(38).during(100), // 4
			nothingFor(15) //5
		  ).protocols(httpProtocol)
		);
  }
}
