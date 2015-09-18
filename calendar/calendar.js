
function calendar(baseday)
{
	var unavailableDates = [
  "2015-9-19", "2015-9-17"
];

		var dateDay;
		var date;
		if (baseday != undefined) {
			date = baseday;
		} else {
			date = new Date();
			dateDay = new Date();
		}
		
		
        var day = date.getDate();
        var month = date.getMonth();
        var year = date.getFullYear();

        months = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
        days_in_month = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
        if(year%4 == 0 && year!=1900)
        {
                days_in_month[1]=29;
        }
		
		// nbre de jours de la semaine
		var initDec = day - date.getDay();
        total = 7;
        var date_today = months[month]+' '+year;
        beg_w = date;
        beg_w.setDate(1);
        if(beg_w.getDate()==2)
        {
                beg_w=setDate(0);
        }
        beg_w = beg_w.getDay();
        document.write('<table class="cal_calendar"><tbody id="cal_body"><tr><th><img src="./img/left.png" onclick="previous()"></th><th colspan="5">'+date_today+'</th><th><img src="./img/right.png" onclick="next()"></th></tr>');
        document.write('<tr class="cal_d_weeks"><td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td></tr><tr>');
        week = 0;
		
		// 
		var forbidden = false;
        for(i=initDec;i<initDec+7;i++)
        {
                if(dateDay.getDate()==i)
                {
                    document.write('<td class="cal_today">'+i+'</td>');
                }
                else if (i < dateDay.getDate()) {
					document.write('<td class="cal_days_bef_aft">'+i+'</td>');
				} else {
					var monthc = date.getMonth() +1;
					
					var currentdate = date.getFullYear() +'-'+ monthc + '-' + i;
					
					for (var j = 0; j < unavailableDates.length; j++) {
						  if (currentdate == unavailableDates[j]) {
							  forbidden = true;
							  break;
						  }
					}
					
					if (forbidden) {
						document.write('<td class="cal_days_busy">'+i+'</td>');
					} else {
						document.write('<td>'+i+'</td>');
					}
					
					forbidden = false;
                }
        }
		document.write('</tr>');

        document.write('</tbody></table>');
        return true;
}

function next(){
	var nextweek = new Date(date.getFullYear(), date.getMonth(), date.getDate() + 7);
	calendar(nextweek);
}

function previous() {
	var previousweek = new Date(date.getFullYear(), date.getMonth(), date.getDate() - 7);
	calendar(previousweek);
}