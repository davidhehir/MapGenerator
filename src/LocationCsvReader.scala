package com.StaticMapGenerator.IO {

import java.io.FileNotFoundException

/**
 * LocationCsvReader:
 * File reader for csv data to a list of locations
 */
class LocationCsvReader() {

  /**
   * Parses a file and returns a list of valid Locations
   * inside the given file.
   * @param fileName the file to parse
   * @return A list of locations read from the file.
   */
  def ParseFile(fileName: String): List[Location] = {
    if (java.io.File(fileName).exists()) {
      throw new FileNotFoundException("File " + fileName + " cannot be found")
    }

    val locations = scala.io.Source.fromFile(file).getLines().map {
      line : String => ConvertLineToLocation(line);
    }

    // remove None options and return the valid locations
    locations.flatten
  }

  /** Converts a line from file into a location object.
    * The line format is expected as:
    * 1,2,3,4
    * 1: the number order this location was entered
    * 2: the longitude of the location
    * 3: the latitude of the location
    * 4: the location name.
    *
    * @param line the line to parse
    * @return a location object containing the data found within the supplied line or None if the line is in an
    *         incorrect format for parsing.
    */
  private def ConvertLineToLocation(line: String): Location = {
    val entries = line.split(',')

    // validate input:
    // not enough args return nothing
    if (entries.length != 4)
      return None

    // return the location for this line
    Some(new Location(entries(3), entries(2), entries(1)))
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
class Location(name: String, latitude: Double, longitude: Double) {
  val Name: String = name
  val Latitude: Double = latitude
  val Longitude: Double = longitude
}

}
