CREATE TABLE IF NOT EXISTS client (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    default_scopes VARCHAR(255)
}

CREATE TABLE IF NOT EXISTS grant_type (
    id INT NOT NULL AUTO_INCREMENT,
    status VARCHAR(20),
    FOREIGN KEY (id) REFERENCES client(client_id)
);