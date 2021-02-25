SELECT name
from animal_ins
where datetime = (select min(datetime) from animal_ins);
#------------------------OR---------------------------------
SELECT name
from animal_ins
order by datetime
limit 1;

