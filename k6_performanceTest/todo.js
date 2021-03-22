import http from 'k6/http';
import { group, sleep } from 'k6';
export let options = {
    stages: [
        { duration: '5s', target: 20 }, // simulate ramp-up of traffic from 1 to 100 users over 5 minutes.
        { duration: '10s', target: 40 }, // stay at 100 users for 10 minutes
        { duration: '5s', target: 0 }, // ramp-down to 0 users
    ],
    thresholds: {
        http_req_duration: ['p(99)<1500'], // 99% of requests must complete below 1.5s
        'visitted in successfully': ['p(99)<1500'], // 99% of requests must complete below 1.5s
    },
};

const BASE_URL = 'https://todomvc.com/';


export default () => {
    group('visit homepage', function () {
        // load homepage resources
        let req, res;
        req = [{
            "method": "get",
            "url": `${BASE_URL}/examples/vue/`,
        }]
        res = http.batch(req);
        sleep(0.51);
    });
};