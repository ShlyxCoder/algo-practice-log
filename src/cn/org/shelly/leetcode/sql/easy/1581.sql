select customer_id,  count(customer_id) count_no_trans from Visits
where not exists (select 1 from Transactions t where t.visit_id = visits.visit_id)
group by customer_id;