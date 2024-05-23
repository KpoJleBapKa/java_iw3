<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Department Management</title>
    <!-- Стилі тут, за потреби -->
</head>
<body>
    <h1>Список Кафедр</h1>
    <!-- Відображення списку кафедр -->
    <ul>
        <#list departmentsList as department>
            <li>Кафедра: ${department} <a href="/departments/delete/${department_index}">Видалити</a></li>
        </#list>
    </ul>

    <!-- Форма для додавання нової кафедри -->
    <form action="/departments" method="post">
        <input type="text" name="departmentName" required>
        <button type="submit">Додати Кафедру</button>
    </form>
</body>
</html>
