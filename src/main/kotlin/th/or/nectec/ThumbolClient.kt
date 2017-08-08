package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs

class ThumbolClient {

    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg
    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(-40)/1.jpg
    val timeout = 5000 // 5000 milliseconds = 5 seconds.
    val readTimeout = 9000 // 9000 milliseconds = 9 seconds.

    val default_width = 500
    val default_height = 500

    val trim="Enable"
    val fitin="Disable"

    val testurl :String ="http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg"


    fun getImage(part_file: String){
    }
    fun getImage(filter: String,part_file: String){

    }






    private fun download(urlpart :String):ByteArray?{

        var data:ByteArray? = null

        testurl.httpGet().timeout(timeout).timeoutRead(readTimeout).response { request, response, result ->
            if (response.httpStatusCode==200){
                data=result.get()
            }
        }
        return data
    }
}