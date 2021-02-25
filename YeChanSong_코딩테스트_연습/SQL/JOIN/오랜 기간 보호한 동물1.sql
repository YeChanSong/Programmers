SELECT a.NAME, a.DATETIME
from animal_outs as b right outer join animal_ins as a
on a.animal_id = b.animal_id
where b.sex_upon_outcome is null
order by a.datetime
limit 3;

