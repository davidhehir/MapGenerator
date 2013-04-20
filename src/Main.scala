import com.StaticMapGenerator.IO.LocationCsvReader

/**
 * Main Map generation
 */
object MapGeneration {
  def main(args: Array[String]) {

    if (length(args) != 2) {
      println("Usage: MapGeneration.exe Input.csv Output.png")
    }

    val inputLocationData = args(0)
    val imageFileName = args(1)

    // get the locations:
    val locations = (new LocationCsvReader).ParseFile(inputLocationData)

    if (length(locations) == 0) {
      println("File contained no location data")
      System.exit(1)
    }





  }

}
