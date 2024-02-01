CREATE TABLE IF NOT EXISTS Music(
    ID SERIAL PRIMARY KEY,
    Title TEXT NOT NULL,
    Seconds int,
    firstDate DATE,
    latestDate DATE,
    DAW TEXT,
    Lyrics TEXT
);
