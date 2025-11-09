# 🌐 Social Networking Microservices (Spring Boot + Gradle + Kubernetes)

This project contains multiple Spring Boot microservices for a social networking application.  
Each service is containerized using Docker and deployed to Kubernetes.

---
# 🚀 Social Networking Platform (Spring Boot + Kubernetes)

## 📦 Microservices
| Service | Port | Description |
|----------|------|-------------|
| user-service | 8081 | Manages users |
| auth-service | 8082 | Handles authentication and JWT |
| profile-service | 8083 | User profiles |
| post-service | 8084 | Posts CRUD |
| feed-service | 8085 | Feed aggregation |
| comment-service | 8086 | Post comments |
| like-service | 8087 | Post likes |
| notification-service | 8088 | User notifications |

---

## 🛠️ Deployment Steps

```bash
# 1. Build JAR
./gradlew clean build

# 2. Build Docker image
docker build -t vivek/auth-service .

# 3. Push to registry (example)
docker push vivek/auth-service

# 4. Deploy to Kubernetes
kubectl apply -f k8s/auth-service.yaml

## 📁 Microservices Included
| Service Name       | Port  | Description                        |
|--------------------|-------|------------------------------------|
| user-service       | 8081  | Handles user registration & login  |
| profile-service    | 8082  | Manages user profiles              |
| friendship-service | 8083  | Handles friendship requests        |

---

## 🧰 Prerequisites
Before starting, ensure you have the following installed:

- **Java 17+**
- **Gradle 8+**
- **Docker Desktop** (with Kubernetes enabled)
- **kubectl CLI**
- **(Optional)** Minikube or kind for local clusters

---

## ⚙️ Step 1: Build and Package JARs
Run this in each service folder:

```bash
./gradlew clean build -x test

```
---

```bash
Verify the output:
ls build/libs/

Run from each service directory

docker build -t user-service:1.0.0 .
docker build -t profile-service:1.0.0 .
docker build -t friendship-service:1.0.0 .

Check all images:
docker images

```
## Step 3: Create Kubernetes Deployments and Services
user-service.yaml
```bash
apiVersion: apps/v1
kind: Deployment
metadata:
  name: user-service
spec:
  replicas: 1
  selector:
    matchLabels:
      app: user-service
  template:
    metadata:
      labels:
        app: user-service
    spec:
      containers:
        - name: user-service
          image: user-service:1.0.0
          ports:
            - containerPort: 8081
---
apiVersion: v1
kind: Service
metadata:
  name: user-service
spec:
  selector:
    app: user-service
  ports:
    - port: 8081
      targetPort: 8081
  type: ClusterIP

```
# Auth-Service.yaml
```bash
apiVersion: apps/v1
kind: Deployment
metadata:
  name: auth-service
spec:
  replicas: 1
  selector:
    matchLabels:
      app: auth-service
  template:
    metadata:
      labels:
        app: auth-service
    spec:
      containers:
        - name: auth-service
          image: vivek/auth-service:latest
          ports:
            - containerPort: 8082
---
apiVersion: v1
kind: Service
metadata:
  name: auth-service
spec:
  selector:
    app: auth-service
  ports:
    - protocol: TCP
      port: 8082
      targetPort: 8082
  type: ClusterIP
```
# profile-service.yaml
```bash
apiVersion: apps/v1
kind: Deployment
metadata:
  name: profile-service
spec:
  replicas: 1
  selector:
    matchLabels:
      app: profile-service
  template:
    metadata:
      labels:
        app: profile-service
    spec:
      containers:
        - name: profile-service
          image: profile-service:1.0.0
          ports:
            - containerPort: 8082
---
apiVersion: v1
kind: Service
metadata:
  name: profile-service
spec:
  selector:
    app: profile-service
  ports:
    - port: 8082
      targetPort: 8082
  type: ClusterIP

```

# friendship-service.yaml
```bash
apiVersion: apps/v1
kind: Deployment
metadata:
  name: friendship-service
spec:
  replicas: 1
  selector:
    matchLabels:
      app: friendship-service
  template:
    metadata:
      labels:
        app: friendship-service
    spec:
      containers:
        - name: friendship-service
          image: friendship-service:1.0.0
          ports:
            - containerPort: 8083
---
apiVersion: v1
kind: Service
metadata:
  name: friendship-service
spec:
  selector:
    app: friendship-service
  ports:
    - port: 8083
      targetPort: 8083
  type: ClusterIP

```

## Step 4: Deploy All Services
```bash
kubectl apply -f user-service.yaml
kubectl apply -f profile-service.yaml
kubectl apply -f friendship-service.yaml

Check deployments and pods: 
kubectl get pods
kubectl get svc

```
## Step 5: Access Services via Port Forwarding
# Forward the ports to access from your browser:
```bash
kubectl port-forward svc/user-service 8081:8081 &
kubectl port-forward svc/profile-service 8082:8082 &
kubectl port-forward svc/friendship-service 8083:8083 &

Now you can test: 
curl http://localhost:8081/api/users
curl http://localhost:8082/api/profile
curl http://localhost:8083/api/friendship
```
# Step 6: Cleanup
```bash
To delete everything:
kubectl delete -f user-service.yaml
kubectl delete -f profile-service.yaml
kubectl delete -f friendship-service.yaml

```
# Folder Structure
```bash
social-network/
│
├── user-service/
│   ├── build.gradle
│   ├── Dockerfile
│   └── src/
│
├── profile-service/
│   ├── build.gradle
│   ├── Dockerfile
│   └── src/
│
├── friendship-service/
│   ├── build.gradle
│   ├── Dockerfile
│   └── src/
│
└── README.md
```