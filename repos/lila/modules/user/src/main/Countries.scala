package lila.user

import scala._

object Countries {

  val all = List(
    "AD"     -> "Andorra",
    "AE"     -> "United Arab Emirates",
    "AF"     -> "Afghanistan",
    "AG"     -> "Antigua and Barbuda",
    "AL"     -> "Albania",
    "AM"     -> "Armenia",
    "AO"     -> "Angola",
    "AR"     -> "Argentina",
    "AT"     -> "Austria",
    "AU"     -> "Australia",
    "AZ"     -> "Azerbaijan",
    "BA"     -> "Bosnia-Herzegovina",
    "BB"     -> "Barbados",
    "BD"     -> "Bangladesh",
    "BE"     -> "Belgium",
    "BF"     -> "Burkina Faso",
    "BG"     -> "Bulgaria",
    "BH"     -> "Bahrain",
    "BI"     -> "Burundi",
    "BJ"     -> "Benin",
    "BN"     -> "Brunei",
    "BO"     -> "Bolivia",
    "BR"     -> "Brazil",
    "BS"     -> "Bahamas",
    "BT"     -> "Bhutan",
    "BW"     -> "Botswana",
    "BY"     -> "Belarus",
    "BZ"     -> "Belize",
    "CA"     -> "Canada",
    "CD"     -> "Congo (Democratic Rep.)",
    "CF"     -> "Central African Republic",
    "CG"     -> "Congo (Brazzaville)",
    "CH"     -> "Switzerland",
    "CI"     -> "Cote d'Ivoire",
    "CL"     -> "Chile",
    "CM"     -> "Cameroon",
    "CN"     -> "China",
    "CO"     -> "Colombia",
    "CR"     -> "Costa Rica",
    "CU"     -> "Cuba",
    "CV"     -> "Cape Verde",
    "CY"     -> "Cyprus",
    "CZ"     -> "Czech Republic",
    "DE"     -> "Germany",
    "DJ"     -> "Djibouti",
    "DK"     -> "Denmark",
    "DM"     -> "Dominica",
    "DO"     -> "Dominican Republic",
    "DZ"     -> "Algeria",
    "EC"     -> "Ecuador",
    "EE"     -> "Estonia",
    "EG"     -> "Egypt",
    "EH"     -> "Western Sahara",
    "ER"     -> "Eritrea",
    "ES"     -> "Spain",
    "ET"     -> "Ethiopia",
    "FI"     -> "Finland",
    "FJ"     -> "Fiji",
    "FM"     -> "Micronesia",
    "FO"     -> "Faroe Islands",
    "FR"     -> "France",
    "GA"     -> "Gabon",
    "GB"     -> "United Kingdom",
    "GB-ENG" -> "England",
    "GB-SCT" -> "Scotland",
    "GB-WLS" -> "Wales",
    "GD"     -> "Grenada",
    "GE"     -> "Georgia",
    "GG"     -> "Guernsey",
    "GH"     -> "Ghana",
    "GL"     -> "Greenland",
    "GM"     -> "Gambia",
    "GN"     -> "Guinea",
    "GQ"     -> "Equatorial Guinea",
    "GR"     -> "Greece",
    "GT"     -> "Guatemala",
    "GW"     -> "Guinea-Bissau",
    "GY"     -> "Guyana",
    "HK"     -> "Hong Kong",
    "HN"     -> "Honduras",
    "HR"     -> "Croatia",
    "HT"     -> "Haiti",
    "HU"     -> "Hungary",
    "ID"     -> "Indonesia",
    "IE"     -> "Ireland",
    "IL"     -> "Israel",
    "IM"     -> "Isle of Man",
    "IN"     -> "India",
    "IQ"     -> "Iraq",
    "IR"     -> "Iran",
    "IS"     -> "Iceland",
    "IT"     -> "Italy",
    "JE"     -> "Jersey",
    "JM"     -> "Jamaica",
    "JO"     -> "Jordan",
    "JP"     -> "Japan",
    "KE"     -> "Kenya",
    "KG"     -> "Kyrgyzstan",
    "KH"     -> "Cambodia",
    "KI"     -> "Kiribati",
    "KM"     -> "Comoros",
    "KN"     -> "Saint Kitts and Nevis",
    "KP"     -> "North Korea",
    "KR"     -> "South Korea",
    "KW"     -> "Kuwait",
    "KY"     -> "Cayman Islands",
    "KZ"     -> "Kazakhstan",
    "LA"     -> "Laos",
    "LB"     -> "Lebanon",
    "LC"     -> "Saint Lucia",
    "LI"     -> "Liechtenstein",
    "LK"     -> "Sri Lanka",
    "LR"     -> "Liberia",
    "LS"     -> "Lesotho",
    "LT"     -> "Lithuania",
    "LU"     -> "Luxembourg",
    "LV"     -> "Latvia",
    "LY"     -> "Libya",
    "MA"     -> "Morocco",
    "MD"     -> "Moldova",
    "ME"     -> "Montenegro",
    "MG"     -> "Madagascar",
    "MH"     -> "Marshall Islands",
    "MK"     -> "Macedonia",
    "ML"     -> "Mali",
    "MM"     -> "Myanmar",
    "MN"     -> "Mongolia",
    "MO"     -> "Macao",
    "MR"     -> "Mauritania",
    "MT"     -> "Malta",
    "MU"     -> "Mauritius",
    "MV"     -> "Maldives",
    "MW"     -> "Malawi",
    "MX"     -> "Mexico",
    "MY"     -> "Malaysia",
    "MZ"     -> "Mozambique",
    "NA"     -> "Namibia",
    "NE"     -> "Niger",
    "NG"     -> "Nigeria",
    "NI"     -> "Nicaragua",
    "NL"     -> "Netherlands",
    "NO"     -> "Norway",
    "NP"     -> "Nepal",
    "NR"     -> "Nauru",
    "NZ"     -> "New Zealand",
    "OM"     -> "Oman",
    "PA"     -> "Panama",
    "PE"     -> "Peru",
    "PG"     -> "Papua New Guinea",
    "PH"     -> "Philippines",
    "PK"     -> "Pakistan",
    "PL"     -> "Poland",
    "PS"     -> "Palestine",
    "PT"     -> "Portugal",
    "PW"     -> "Palau",
    "PY"     -> "Paraguay",
    "QA"     -> "Qatar",
    "RO"     -> "Romania",
    "RS"     -> "Serbia",
    "RU"     -> "Russia",
    "RW"     -> "Rwanda",
    "SA"     -> "Saudi Arabia",
    "SB"     -> "Solomon Islands",
    "SC"     -> "Seychelles",
    "SD"     -> "Sudan",
    "SE"     -> "Sweden",
    "SG"     -> "Singapore",
    "SI"     -> "Slovenia",
    "SK"     -> "Slovakia",
    "SL"     -> "Sierra Leone",
    "SM"     -> "San Marino",
    "SN"     -> "Senegal",
    "SO"     -> "Somalia",
    "SR"     -> "Suriname",
    "ST"     -> "Sao Tome and Principe",
    "SV"     -> "El Salvador",
    "SY"     -> "Syria",
    "SZ"     -> "Swaziland",
    "TD"     -> "Chad",
    "TG"     -> "Togo",
    "TH"     -> "Thailand",
    "TJ"     -> "Tajikistan",
    "TL"     -> "Timor-Leste",
    "TM"     -> "Turkmenistan",
    "TN"     -> "Tunisia",
    "TO"     -> "Tonga",
    "TR"     -> "Turkey",
    "TT"     -> "Trinidad and Tobago",
    "TV"     -> "Tuvalu",
    "TW"     -> "Taiwan",
    "TZ"     -> "Tanzania",
    "UA"     -> "Ukraine",
    "UG"     -> "Uganda",
    "US"     -> "United States",
    "UY"     -> "Uruguay",
    "UZ"     -> "Uzbekistan",
    "VC"     -> "Saint Vincent and the Grenadines",
    "VE"     -> "Venezuela",
    "VN"     -> "Vietnam",
    "VU"     -> "Vanuatu",
    "WS"     -> "Samoa",
    "YE"     -> "Yemen",
    "ZA"     -> "South Africa",
    "ZM"     -> "Zambia",
    "ZW"     -> "Zimbabwe"
  ).sortBy(_._2)

  val map = all.toMap

  val codeSet = map.keySet

  def info(code: String): Option[(String, String)] =
    map get code map { code -> _ }
}
