package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import org.junit.Assert
import org.junit.Test

class ThumbolClientTest {
    val clientTest1 :ThumbolClient = ThumbolClient()


    val timeout = 5000 // 5000 milliseconds = 5 seconds.
    val readTimeout = 9000 // 9000 milliseconds = 9 seconds.

    val testurl :String ="http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg"

    @Test fun testDownload(){


        testurl.httpGet().response { request, response, result ->

            System.out.println(result);
            System.out.println("ssss");
            Assert.assertEquals("", "5");
        }
        System.out.println("ddddd");

    }

}