# ale-arsenal

## DB

### Start

```bash
docker compose up db -d
```

### Reset

These are run especially when migration changes occur

```bash
docker compose kill db
docker compose rm db -f
docker compose up db -d

```

## Frontend

### Install

```bash
cd ./ale-arsenal-frontend
npm run install
```

### Run

```bash
cd ./ale-arsenal-frontend
npm run dev
```

## Run backend

```bash
cd ./ale-arsenal-backend
DB_URI=localhost:5432/ DB_USER=username DB_PASSWORD=password ./gradlew run
```