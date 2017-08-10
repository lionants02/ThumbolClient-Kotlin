package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import org.junit.Assert
import org.junit.Test

class ThumbolClientTest {
    val clientTest1: ThumbolURL = ThumbolURL("http://localhost:8000", "1.jpg").apply {
        brightness = 100
    }


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
            rgb_amount.rAmount = 20
            rgb_amount.gAmount = -20
            rgb_amount.bAmount = 40
            rotate = 180
            max_bytes = 102400
            no_upscale = true
            noise=50
        }
        //System.out.println(thumbolurlTest.getUrl())
        Assert.assertEquals("http://localhost:8000/unsafe/filters:max_bytes(102400):no_upscale():noise(50):rgb(20,-20,40):rotate(180)/1.jpg", thumbolurlTest.getUrl())
        thumbolurlTest = ThumbolURL("http://localhost:8000", "1.jpg").apply {
            quality=10
            strip_icc = true
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