$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/tyerubandhi/Downloads/CucumberSeleniumFramework-master/src/main/java/Features/rlh.feature");
formatter.feature({
  "line": 1,
  "name": "Booking a hotel through RLH",
  "description": "",
  "id": "booking-a-hotel-through-rlh",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Book a hotel",
  "description": "Description:book a hotel through quickbook",
  "id": "booking-a-hotel-through-rlh;book-a-hotel",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on RLH website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters \"\u003clocation\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose hotel in entered location",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "select hotel from different options",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Fill the form to book a hotel",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Get the price details",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "booking-a-hotel-through-rlh;book-a-hotel;",
  "rows": [
    {
      "cells": [
        "location"
      ],
      "line": 12,
      "id": "booking-a-hotel-through-rlh;book-a-hotel;;1"
    },
    {
      "cells": [
        "Red lion hotel port angeles"
      ],
      "line": 13,
      "id": "booking-a-hotel-through-rlh;book-a-hotel;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Book a hotel",
  "description": "Description:book a hotel through quickbook",
  "id": "booking-a-hotel-through-rlh;book-a-hotel;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on RLH website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters \"Red lion hotel port angeles\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose hotel in entered location",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "select hotel from different options",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Fill the form to book a hotel",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Get the price details",
  "keyword": "And "
});
formatter.match({
  "location": "BookaHotelRLH.user_is_on_RLH_website()"
});
formatter.result({
  "duration": 50079399641,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Red lion hotel port angeles",
      "offset": 13
    }
  ],
  "location": "BookaHotelRLH.user_enters(String)"
});
formatter.result({
  "duration": 1661709066,
  "status": "passed"
});
formatter.match({
  "location": "BookaHotelRLH.choose_hotel_in_entered_location()"
});
formatter.result({
  "duration": 19999808949,
  "status": "passed"
});
formatter.match({
  "location": "BookaHotelRLH.select_hotel_from_different_options()"
});
formatter.result({
  "duration": 58747754060,
  "status": "passed"
});
formatter.match({
  "location": "BookaHotelRLH.fill_the_form_to_book_a_hotel()"
});
formatter.result({
  "duration": 18646722975,
  "status": "passed"
});
formatter.match({
  "location": "BookaHotelRLH.get_the_price_details()"
});
formatter.result({
  "duration": 20714991105,
  "status": "passed"
});
});