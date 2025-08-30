select a.machine_id, round(AVG(b.timestamp - a.timestamp),3) processing_time
from activity a
    join activity b on a.process_id = b.process_id && a.machine_id = b.machine_id
where a.activity_type = 'Start' && b.activity_type = 'end'
group by a.machine_id;