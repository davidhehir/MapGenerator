import com.sun.media.sound.InvalidFormatException

class LocationCsvReader(fileName : String) {
  val file : String = fileName


  def Parse() {
    val lines = scala.io.Source.fromFile(file).getLines().foreach {
      line : String => {line.split(',')}
    }
  }

  def ConvertLineToLocation(line : String) : Location =
  {
    val entries = line.split(',')

    if (entries.length != 4)
    {
      throw new InvalidFormatException("Line: '" + line + "' does not have 4 entries")
    }

    // return the location for this line
    new Location(entries(2), entries(1), entries(3))
  }
}

/** A Location of an event
  *
  * @constructor create a new location with name, latitude and longitude.
  * @param name the location name
  * @param latitude the location latitude.
  *                 This value will be negative for south of the equator
  * @param longitude the location longitude.
  */
class Location(name: String, latitude : Double, longitude : Double)
{
  val Name : String = name
  val Latitude : Double = latitude
  val Longitude : Double = longitude
}
