SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
from animal_outs as a left outer join animal_ins as b
on a.animal_id = b.animal_id
where b.sex_upon_intake like 'Intact%' and (a.sex_upon_outcome like 'Spayed%' or a.sex_upon_outcome like 'Neutered%')
order by a.animal_id;
