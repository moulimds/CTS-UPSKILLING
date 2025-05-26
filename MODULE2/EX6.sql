SELECT 
    e.title,
    e.city,
    COUNT(CASE WHEN res.resource_type = 'pdf' THEN 1 END) as pdf_count,
    COUNT(CASE WHEN res.resource_type = 'image' THEN 1 END) as image_count,
    COUNT(CASE WHEN res.resource_type = 'link' THEN 1 END) as link_count,
    COUNT(res.resource_id) as total_resources
FROM Events e
LEFT JOIN Resources res ON e.event_id = res.event_id
GROUP BY e.event_id, e.title, e.city
ORDER BY total_resources DESC;
