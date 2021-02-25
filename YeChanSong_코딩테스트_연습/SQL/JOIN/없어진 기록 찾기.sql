SELECT a.ANIMAL_ID, a.NAME
from animal_outs as a left outer join animal_ins as b
on a.animal_id = b.animal_id
where intake_condition is null;
