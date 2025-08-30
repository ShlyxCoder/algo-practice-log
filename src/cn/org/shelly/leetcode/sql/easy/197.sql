select a.id from weather a
join weather b on b.recordDate = DATE_SUB(a.recordDate, interval 1 day)
where a.temperature > b.temperature;