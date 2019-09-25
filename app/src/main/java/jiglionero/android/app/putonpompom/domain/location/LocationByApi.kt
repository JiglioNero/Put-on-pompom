package jiglionero.android.app.putonpompom.domain.location

data class LocationByApi(
    val AdministrativeArea: AdministrativeArea = AdministrativeArea(),
    val Country: Country = Country(),
    val DataSets: List<Any> = listOf(),
    val EnglishName: String = "",
    val GeoPosition: GeoPosition = GeoPosition(),
    val IsAlias: Boolean = false,
    val Key: String = "",
    val LocalizedName: String = "",
    val PrimaryPostalCode: String = "",
    val Rank: Int = 0,
    val Region: Region = Region(),
    val SupplementalAdminAreas: List<Any> = listOf(),
    val TimeZone: TimeZone = TimeZone(),
    val Type: String = "",
    val Version: Int = 0
)