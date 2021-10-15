SELECT * 
from places a
where a.host_id in (select b.host_id 
               from places b
               group by b.host_id
               having count(*)>1);