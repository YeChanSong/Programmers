SELECT hour(datetime) as HOUR, count(*) as COUNT
from animal_outs
group by hour(datetime)
having 9<= HOUR and HOUR<20
order by HOUR;
