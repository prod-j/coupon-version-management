import random
from locust import task, FastHttpUser, stats

stats.PERCENTILES_TO_CHART = [0.95, 0.99]


class CouponIssueV1(FastHttpUser):
    connection_timeout = 10.0
    network_timeout = 10.0

    @task
    def issue(self):
        payload = {
            "userId": random.randint(1, 10000000),
            "couponId": 1
        }
        with self.rest("POST", "/v1/issue", json=payload):
            pass
