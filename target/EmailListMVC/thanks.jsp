<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Murach Survey - Thank You</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 16px 36px;
            color: black;
            font-size: 18px;
        }

        img {
            width: 134px;
            height: auto;
        }

        h1, h2 {
            color: #187e7c;
        }

        h1 {
            font-size: 30px;
        }

        h2 {
            font-size: 23px;
            margin-top: 25px;
        }

        .result-row {
            margin-bottom: 12px;
        }

        .result-row label {
            display: inline-block;
            width: 220px;
            font-weight: bold;
        }

        .result-row span {
            color: #333;
        }

        button {
            margin-top: 20px;
            padding: 7px 15px;
            font-size: 16px;
            cursor: pointer;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>

<body>

    <!-- Kiem tra du lieu User -->
    <c:choose>

        <c:when test="${not empty user}">

            <img src="murach.png" alt="Murach Logo">

            <h1>Thank You!</h1>

            <p>
                Thank you for completing our survey.
                Here is the information that you entered:
            </p>

            <!-- Thong tin ca nhan -->
            <h2>Your information:</h2>

            <div class="result-row">
                <label>First Name:</label>
                <span><c:out value="${user.firstName}"/></span>
            </div>

            <div class="result-row">
                <label>Last Name:</label>
                <span><c:out value="${user.lastName}"/></span>
            </div>

            <div class="result-row">
                <label>Email:</label>
                <span><c:out value="${user.email}"/></span>
            </div>

            <div class="result-row">
                <label>Date of Birth:</label>
                <span><c:out value="${user.dateOfBirth}"/></span>
            </div>

            <!-- Nguon biet den website -->
            <h2>How did you hear about us?</h2>

            <div class="result-row">
                <label>Your answer:</label>
                <span><c:out value="${user.hearAboutUsText}"/></span>
            </div>

            <!-- Nhan thong bao -->
            <h2>Announcements:</h2>

            <div class="result-row">
                <label>Email announcements:</label>
                <span>
                    <c:choose>
                        <c:when test="${user.emailAnnouncements}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </span>
            </div>

            <div class="result-row">
                <label>Postal announcements:</label>
                <span>
                    <c:choose>
                        <c:when test="${user.postalAnnouncements}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </span>
            </div>

            <!-- Phuong thuc lien he -->
            <h2>Contact method:</h2>

            <div class="result-row">
                <label>Please contact me by:</label>
                <span><c:out value="${user.contactText}"/></span>
            </div>

            <!-- Quay lai trang Survey -->
            <a href="">
                <button type="button">Return to Survey</button>
            </a>

        </c:when>

        <c:otherwise>

            <h1>No survey information found!</h1>

            <a href="">Return to Survey</a>

        </c:otherwise>

    </c:choose>

</body>
</html>
