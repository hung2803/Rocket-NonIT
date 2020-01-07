-- Drop the database if it already exists
DROP DATABASE IF EXISTS Quanlythisinh;
-- Create database
CREATE DATABASE IF NOT EXISTS Quanlythisinh;
USE Quanlythisinh;

-- Drop the table if it already exists


-- Drop the table if it already exists
DROP TABLE IF EXISTS 	Candidate;
CREATE TABLE	Candidate (
		ID				INT AUTO_INCREMENT PRIMARY KEY,
        FirstName		NVARCHAR(20) NOT NULL,
		LastName		NVARCHAR(20) NOT NULL,
        Phone			CHAR(15) NOT NULL,
		Email			CHAR(40) NOT NULL,
        `Password`		VARCHAR(20) NOT NULL,
        `Role`			ENUM ('ExperienceCandidate','FresherCandidate'),
		ExpInYear		TINYINT NOT NULL,
        ProSkill		VARCHAR(30) NOT NULL,
		GraduationRank	ENUM('Excellence', 'Good', 'Fair', 'Poor')
);
