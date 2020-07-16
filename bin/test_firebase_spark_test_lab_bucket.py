from firebase_spark_test_lab_bucket import extract_gcs_bucket_line_from_test_lab_results_file, \
    extract_gsc_bucket_root_from_gcs_bucket_line, construct_gcs_bucket_url

gcs_bucket_line = extract_gcs_bucket_line_from_test_lab_results_file(
    '/home/jsears/GIT_REPOS/brexitsoundboard/bin/results.txt')
assert "GCS bucket" in gcs_bucket_line

gsc_bucket_root = extract_gsc_bucket_root_from_gcs_bucket_line(gcs_bucket_line)
assert gsc_bucket_root == 'test-lab-45uzmzqr0t1n4-wryzyy6b0558w/2019-01-06_21:36:57.551592_WESy/'

gcs_bucket_url = construct_gcs_bucket_url(gsc_bucket_root,
                                          'Nexus6P-27-en-portrait',
                                          '/artifacts/coverage.ec')
assert gcs_bucket_url == 'gs://test-lab-45uzmzqr0t1n4-wryzyy6b0558w/2019-01-06_21:36:57.551592_WESy/Nexus6P-27-en-portrait/artifacts/coverage.ec'
