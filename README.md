# nure-db
This is a Web API and database project I am developing to sharpen my skills. And for fun!
*WORK IN PROGRESS*

## About
Spring Boot Java backend. Database? Haven't decided yet. Frontend? Probably React.

## Tables

### Source
A resource, for example an image, a sound file, video...


| id      | name   | url    | host   | isPublic |
|---------|--------|--------|--------|----------|
| integer | string | string | string | bool     |

### Profile
A person profile

| id      | name   |
|---------|--------|
| integer | string |

### Tag
A tag to describe a resource

| id      | value  |
|---------|--------|
| integer | string |

### Music
A song, music track. Original composition, or remix.
**Relationships**
- Source (avaliable at)
- Vocalist (sung by)
- Music (is remake/mix/master of)
- Artwork (related)
- Profile (posted under)
- Release (included in)

| id      | title  | seconds | firstDate | latestDate | daw    | description | lyrics | isrc   | isRemake |
|---------|--------|---------|-----------|------------|--------|-------------|--------|--------|----------|
| integer | string | integer | date      | date       | string | string      | string | string | boolean  |

### Release
A release containing one or more music tracks
**Relationships**
- Music (includes)
- Artwork (related)