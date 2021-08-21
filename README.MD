To transform string : send "POST" with request body by  to "/string"

To get payment result : send "POST" with paymentList to "/getResult?date=yyyy-MM-dd&tax=false"

Example of paymentsList presented in paymentListExample.xml
Part should be 1050 for 'K' or 1055 for 'П'.
Date example : yyyy-MM-dd (yy-MM-dd will be converted to 20yy-MM-dd).
If date is incorrect will be displayed all results.
To get result for taxes: set "tax" parameter to true (default false).
