SELECT Image.*, Source.* FROM image
JOIN ImageSource ON Image.ID=ImageSource.imageID
JOIN Source ON ImageSource.sourceID=Source.ID;