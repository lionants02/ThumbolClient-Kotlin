package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import org.junit.Assert
import org.junit.Test

class ThumbolClientTest {
    val clientTest1: ThumbolURL = ThumbolURL("http://localhost:8000", "1.jpg").apply {
        brightness = 100
    }


    val timeout = 5000 // 5000 milliseconds = 5 seconds.
    val readTimeout = 9000 // 9000 milliseconds = 9 seconds.

    val testurl: String = "http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg"

    @Test fun getUrl1() {

        var thumbolurlTest: ThumbolURL = ThumbolURL("http://localhost:8000", "1.jpg").
                apply {
                    blur = 10
                    blur_sigma = 30
                    brightness = 10
                    contrast = 50
                    equalize = true
                    format = "png"
                    grayscale = false
                }
        Assert.assertEquals("http://localhost:8000/unsafe/filters:blur(10,30):brightness(10):contrast(50):equalize():format(png)/1.jpg", thumbolurlTest.getUrl())

        thumbolurlTest = ThumbolURL("http://localhost:8000", "1.jpg").apply {
            rAmount = 20
            gAmount = -20
            bAmount = 40
            rotate = 180
        }
        System.out.println(thumbolurlTest.getUrl())
    }


    @Test fun testDownload() {

        var i = 0

        var data: ByteArray
        testurl.httpGet().response { request, response, result ->

            if (response.httpStatusCode == 200) {

                data = result.get()
            }
            System.out.println(result);
            System.out.println("ssss");
            Assert.assertEquals("", "");
            i++;
        }
        //System.out.println("ddddd");

        while (i < 1) Thread.sleep(2000)
    }


}