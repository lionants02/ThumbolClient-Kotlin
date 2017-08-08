class ThumbolClient {

    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg
    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(-40)/1.jpg

    val default_width = 500
    val default_height = 500

    val trim="Enable"
    val fitin="Disable"


    fun getImage(part_file: String){
    }
    fun getImage(filter: String,part_file: String){

    }
    private fun imageDownload(urlpart :String){

    }
}