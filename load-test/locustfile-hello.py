from locust import task, FastHttpUser, stats

stats.PERCENTILES_TO_CHART = [0.95, 0.99]

class HelloWorld(FastHttpUser):
    connection_timeout = 10.0
    network_timeout = 10.0

    @task
    def hello(self):
        response = self.client.get("/hello")
