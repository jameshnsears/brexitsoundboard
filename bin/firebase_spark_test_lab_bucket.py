import argparse


# export GCS_BUCKET=`python3 firebase_spark_test_lab_bucket.py 'results.txt' 'Nexus6P-27-en-portrait' '/artifacts/coverage.ec'`
# gsutil cp $GCS_BUCKET .

def extract_gcs_bucket_line_from_test_lab_results_file(test_lab_results_file):
    for line in open(test_lab_results_file):
        if 'GCS bucket' in line:
            return line


def extract_gsc_bucket_root_from_gcs_bucket_line(test_lab_results_line):
    gcs_bucket = test_lab_results_line[test_lab_results_line.find('/browser/'):]
    gcs_bucket = gcs_bucket[9:]
    gcs_bucket = gcs_bucket[: len(gcs_bucket) - 2]
    return gcs_bucket


def construct_gcs_bucket_url(gcs_bucket_root, test_axis_value, path_to_ec_file):
    return 'gs://' + gcs_bucket_root + test_axis_value + path_to_ec_file


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='extract gcs bucket from firebase spark test lab results file.')
    parser.add_argument('--test_lab_results_file',
                        dest='test_lab_results_file',
                        default='results.txt',
                        help='firebase test lab results file')

    parser.add_argument('--test_axis_value',
                        dest='test_axis_value',
                        default='Nexus6P-27-en-portrait',
                        help='a device used in test lab')

    parser.add_argument('--path_to_ec_file',
                        dest='path_to_ec_file',
                        default='/artifacts/coverage.ec',
                        help='path to artifacts in bucket')
    args = parser.parse_args()

    gcs_bucket_line = extract_gcs_bucket_line_from_test_lab_results_file(args.test_lab_results_file)
    gsc_bucket_root = extract_gsc_bucket_root_from_gcs_bucket_line(gcs_bucket_line)
    print(construct_gcs_bucket_url(gsc_bucket_root, args.test_axis_value, args.path_to_ec_file))
