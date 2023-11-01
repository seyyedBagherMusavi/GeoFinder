# GeoFinder

GeoFind is a Geographic Information System (GIS) project built with Spring Boot 3, MongoDB, Mongock, and Spring Data. It provides advanced search capabilities to discover nearby places based on geographic coordinates.

## Features

- **Nearby Place Search**: Utilize the power of MongoDB's geospatial indexing and Spring Data's magic method `findByLocationNear` to search for nearby places based on a specific location.
- **search in shape**: Utilize the power of MongoDB's geospatial indexing and Spring Data's magic method `findByLocationWithin` to search for  places in shape.
- **Spatial Data Storage**: Store and manage spatial data efficiently using MongoDB's geospatial features within a Spring Boot application.
- **Mongock Database Migration**: Seamlessly handle database migrations and data versioning using Mongock, ensuring smooth updates and maintenance of the GIS project.
- **Easy Integration**: The project is designed to be easily integrated into any Spring Boot application, providing a solid foundation for GIS functionality.


## Getting Started

1. Clone the repository:

```shell
git clone https://github.com/seyyedBagherMusavi/GeoFinder.git
```

2. Navigate to the project directory and run mongo docker:
```shell
cd GeoFind && docker-compose -f mongodb.yml up -d
```
3.Build & run project with mvn command or anything else :)


# 💻 Tech Stack:
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![GIS](https://img.shields.io/badge/gis-%234ea94b.svg?style=for-the-badge&logo=maplibre&logoColor=white)
