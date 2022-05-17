Feature: As a QA
         I want to test the time zone web service data query module
         to ensure the quality of the application


 Scenario Outline: Consult the time zone information
    When Consult the time zone information with
         |Latitude  |Length  |
         |<Latitude>|<Length>|
    Then The service displays
        |Sunrise  |Lng  |Countrycode  |Gmtoffset  |Rawoffset  |Sunset  |Timezoneid  |Dstoffset  |Countryname  |Time  |Lat  |Message  |Value  |StatusCode  |
        |<Sunrise>|<Lng>|<Countrycode>|<Gmtoffset>|<Rawoffset>|<Sunset>|<Timezoneid>|<Dstoffset>|<Countryname>|<Time>|<Lat>|<Message>|<Value>|<StatusCode>|

   Examples:
   |Latitude|Length   |Sunrise         |Lng     |Countrycode|Gmtoffset|Rawoffset|Sunset          |Timezoneid        |Dstoffset|Countryname|Time            |Lat    |Message                |Value|StatusCode|
#   |10.4352a|-84.2582x|                |        |           |         |         |                |                  | 	      |           |                |       |error parsing parameter|14   |200       |
#   |10.4352a|-84.2582 |                |        |           |         |         |                |                  | 	      |           |                |       |error parsing parameter|14   |200       |
#   |10.4352 |-84.2582c|                |        |           |         |         |                |                  | 	      |           |                |       |error parsing parameter|14   |200       |
#   |        |         |                |        |           |         |         |                |                  | 	      |           |                |       |error parsing parameter|14   |200       |
#   |        |-84.2582 |                |        |           |         |         |                |                  | 	      |           |                |       |error parsing parameter|14   |200       |
#   |10.4352a|         |                |        |           |         |         |                |                  | 	      |           |                |       |missing parameter      |14   |200       |
#   |10.4352 |-84.2582 |2022-05-17 05:15|-84.2582|CR         |-6	     |-6        |2022-05-17 17:51|America/Costa_Rica|-6 	  |Costa Rica |2022-05-17 18:34|10.4352|                       |     |200       |
   |3.5353  |-72.573  |2022-05-17 05:38|-72.573 |CO         |-5	     |-5        |2022-05-17 17:55|America/Bogota    |-5 	  |Colombia   |2022-05-17 18:34|3.5353 |                       |     |200       |

