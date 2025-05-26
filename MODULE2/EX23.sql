SELECT 
    YEAR(r.registration_date) as year,
    MONTH(r.registration_date) as month,
    MONTHNAME(r.registration_date) as month_name,
    COUNT(r.registration_id) as registration_count
FROM Registrations r
WHERE r.registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY YEAR(r.registration_date), MONTH(r.registration_date)
ORDER BY year DESC, month DESC;
