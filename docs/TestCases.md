# Test Cases

| ID | Test | Input | Expected Result |
|---|---|---|---|
| TC01 | Display rooms | Menu 1 | All rooms and availability are displayed |
| TC02 | Add guest | Valid name/phone/email | Guest gets a generated ID |
| TC03 | Invalid menu | 99 | Error message is displayed |
| TC04 | Invalid number | `abc` at numeric prompt | Program asks again |
| TC05 | New booking | Valid guest + available room | Booking is created and room becomes occupied |
| TC06 | Occupied room | Select occupied room | Booking is rejected |
| TC07 | Cancel booking | Valid booking ID | Booking removed and room becomes available |
| TC08 | Bill | Valid booking + service charge | Bill shows room charge, service charge, tax and total |
| TC09 | Date validation | `12/09/2026` | Program asks for YYYY-MM-DD |
| TC10 | Dashboard | Menu 5 | Room count and occupancy rate are displayed |
