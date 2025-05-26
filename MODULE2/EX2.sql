SELECT 
    e.title,
    e.city,
    COUNT(f.feedback_id) as feedback_count,
    ROUND(AVG(f.rating), 2) as avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title, e.city
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;
