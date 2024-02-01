SELECT Music.*, Source.* FROM Music
JOIN MusicSource ON Music.ID=MusicSource.musicID
JOIN Source ON MusicSource.sourceID=Source.ID;