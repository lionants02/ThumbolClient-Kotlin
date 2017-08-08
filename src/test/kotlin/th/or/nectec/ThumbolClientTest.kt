package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import org.junit.Assert
import org.junit.Test
import org.junit.Before
import java.util.concurrent.CountDownLatch

class ThumbolClientTest {
    val clientTest1 :ThumbolClient = ThumbolClient().apply { brightness=100
    }


    val timeout = 5000 // 5000 milliseconds = 5 seconds.
    val readTimeout = 9000 // 9000 milliseconds = 9 seconds.

    val testurl :String ="http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg"




    @Test fun testDownload(){

        var i =0

        var data:ByteArray
        testurl.httpGet().response { request, response, result ->

            if (response.httpStatusCode==200){

                data=result.get()
            }
            System.out.println(result);
            System.out.println("ssss");
            Assert.assertEquals("", "5");
            i++;
        }
        //System.out.println("ddddd");

        while (i<1)Thread.sleep(2000)
    }

}