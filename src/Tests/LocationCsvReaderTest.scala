package Tests

import com.StaticMapGenerator.IO.LocationCsvReader

@RunWith(classOf[JUnitRunner])
class LocationCsvReaderTest {

  "A LocationCsvReader" should "return an empty list when reading an empty file" in {
    val reader = new LocationCsvReader
    reader.ConvertLineToLocation("..\\TestData\\empty.csv") should equal (List())

  }

}
