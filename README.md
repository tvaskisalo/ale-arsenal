# ale-arsenal

## DB

### Start dev db

```bash
docker compose up db -d
```

### Start testing db

```bash
docker compose up test-db -d
```

### Reset dev db

These are run especially when migration changes occur

```bash
docker compose kill db
docker compose rm db -f
docker compose up db -d
```

### Reset testing db

```bash
docker compose kill test-db
docker compose rm test-db -f
docker compose up test-db -d
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

### Test
```bash
cd ./ale-arsenal-frontend
npm run test
```

## Backend

### Run

```bash
cd ./ale-arsenal-backend
DB_URI=localhost:5432/ DB_USER=username DB_PASSWORD=password ./gradlew run
```

## Run backend tests
```bash
cd ./ale-arsenal-backend
./gradlew :test
```