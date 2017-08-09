package th.or.nectec

import com.github.kittinunf.fuel.httpGet

class ThumbolClient {

    var timeout :Int = 5000
    var readTimeout :Int = 9000
    val testurl: String = "http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg"


    private fun download(urlpart: String): ByteArray? {

        var data: ByteArray? = null

        testurl.httpGet().timeout(timeout).timeoutRead(readTimeout).response { request, response, result ->
            if (response.httpStatusCode == 200) {
                data = result.get()
            }
        }
        return data
    }
}